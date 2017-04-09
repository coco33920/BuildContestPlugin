package fr.colin.buildcontest;

        import java.io.File;
        import java.io.FileInputStream;
        import java.io.FileOutputStream;
        import java.io.IOException;

public class WorldUtils {

    public static void copyFile(File src, File dest) {
        int length;
        if(src.isDirectory()) {
            if(!dest.exists()) {
                dest.mkdir();
            }

            String[] e = src.list();
            String[] out = e;
            int buffer = e.length;

            for(length = 0; length < buffer; ++length) {
                String file = out[length];
                File srcFile = new File(src, file);
                File destFile = new File(dest, file);
                copyFile(srcFile, destFile);
            }
        } else {
            try {
                FileInputStream var10 = new FileInputStream(src);
                FileOutputStream var11 = new FileOutputStream(dest);
                byte[] var12 = new byte[1024];

                while((length = var10.read(var12)) > 0) {
                    var11.write(var12, 0, length);
                }

                var10.close();
                var11.close();
            } catch (IOException var9) {
                var9.printStackTrace();
            }
        }

        System.out.println("La copie de " + src + " a été correctement éffecutuée !");
    }

    public static boolean deleteFile(File src) {
        if(!src.exists()) {
            return false;
        } else if(src.isDirectory()) {
            File[] files = src.listFiles();

            for(int i = 0; i < files.length; ++i) {
                if(files[i].isDirectory()) {
                    deleteFile(files[i]);
                } else {
                    files[i].delete();
                }
            }

            return src.delete();
        } else {
            return src.delete();
        }
    }
}
