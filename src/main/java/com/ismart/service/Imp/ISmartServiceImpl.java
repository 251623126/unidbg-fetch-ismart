package com.ismart.service.Imp;

import com.github.unidbg.AndroidEmulator;
import com.github.unidbg.Module;
import com.github.unidbg.linux.android.AndroidEmulatorBuilder;
import com.github.unidbg.linux.android.AndroidResolver;
import com.github.unidbg.linux.android.dvm.AbstractJni;
import com.github.unidbg.linux.android.dvm.DalvikModule;
import com.github.unidbg.linux.android.dvm.VM;
import com.github.unidbg.linux.android.dvm.array.ByteArray;
import com.github.unidbg.memory.Memory;
import com.ismart.service.ISmartService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import static com.ismart.utils.FileUtils.loadFile;

@Service
public class ISmartServiceImpl extends AbstractJni implements ISmartService {

    private final AndroidEmulator emulator;
    private final VM vm;
    private final Module module;

    public ISmartServiceImpl() {

        try {
            emulator = AndroidEmulatorBuilder.for32Bit().setProcessName("com.up366.ismart").build();
            final Memory memory = emulator.getMemory(); // 模拟器内存操作接口
            memory.setLibraryResolver(new AndroidResolver(23)); //设置系统类库解析器

            vm = emulator.createDalvikVM(); //依托原apk创建android虚拟机

            DalvikModule dm = vm.loadLibrary(loadFile("ismart/libnative-lib.so").toFile(), true); // 加载so到虚拟内存里
            module = dm.getModule(); // 获得本so模块的句柄

            vm.setJni(this);
            vm.setVerbose(false);
            dm.callJNI_OnLoad(emulator);
        } catch (Exception e) {
            throw new RuntimeException("初始化ISmartServiceImpl失败", e);
        }
    }

    /**
     *  通过调用so里的方法来实现加密ut签名
     * @param bArr 需要加密的字符串
     * @param i 加密的类型
     * @return 加密后的字符串
     */

    @Override
    public String enc(String bArr, int i) {
        synchronized (this) {
            List<Object> list = new ArrayList<>(10);
            list.add(vm.getJNIEnv());   // 第一个入参env;
            list.add(0);
            byte[] arg1 = bArr.getBytes();
            ByteArray byteArray = new ByteArray(vm, arg1);
            list.add(vm.addLocalObject(byteArray));
            list.add(i);
            Number number = module.callFunction(emulator, 0x35D54 + 1, list.toArray());
            byte[] resultArr = (byte[]) vm.getObject(number.intValue()).getValue();
            return bytesToHexString(resultArr);
        }
    }


    private static String bytesToHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            int i = b & 0xFF;
            sb.append(String.format("%02x", i));
        }
        return sb.toString();
    }

}
