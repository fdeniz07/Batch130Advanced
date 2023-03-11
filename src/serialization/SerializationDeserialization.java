package serialization;

import java.io.*;
import java.util.Objects;

//ObjectOutputStream Java objelerini kodlar ve karşılık gelen akışları oluşturur.
//bu işleme serialization denir.
public class SerializationDeserialization {

    public static void main(String[] args) {

        writeObjects();
        readObject();
    }

    //object'leri dosyaya yazdirma : Serialization
    public static void writeObjects() {

        System.out.println("User objeleri olusturuluyor...");
        User user1 = new User(1L, "Ferit", "5464544444412");
        User user2 = new User(2L, "Necmi", "1234567897");
        User user3 = new User(3L, "Asi", "23564742211");
        User user4 = new User(4L, "Mahmut", "77754542144");

        try {
            //objelerin yazılacacağı dosyaya yazmak için
            FileOutputStream fos = new FileOutputStream("user.txt");
            //objeleri yazmak için
            ObjectOutputStream output = new ObjectOutputStream(fos);
            //OOS'in object'leri akisa yazdirabilmesi icin object'lerin Class'i Serializable interface'ini implement etmis olmali.
            // Cünkü öncelikle Object'lerin serilestirilmesi gerekiyor.
            output.writeObject(user1);
            output.writeObject(user2);
            output.writeObject(user3);
            output.writeObject(user4);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //object'leri dosyadan okuma : Deserialization
    public static void readObject() {
        try {
            //okuyacağımız dosyayı belirtelim
            FileInputStream fis=new FileInputStream("user.txt");
            //objectleri okumak için
            ObjectInputStream input=new ObjectInputStream(fis);

            User user1=(User)input.readObject();
            User user2=(User)input.readObject();
            User user3=(User)input.readObject();
            User user4=(User)input.readObject();

            System.out.println(user1);
            System.out.println(user2);
            System.out.println(user3);
            System.out.println(user4);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
