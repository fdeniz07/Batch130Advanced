package enums;

public class Main {

    public static void main(String[] args) {

        System.out.println("========================== VARIABLES ==============================");

        useNonEnumVariable(1);
        useNonEnumVariable(2);
        useNonEnumVariable(3);
        useNonEnumVariable(4);
        useNonEnumVariable(5);
        useNonEnumVariable(100); //CTE,

        System.out.println("========================== ENUMS ==============================");
        useEnumType(TransactionTypeEnum.DEPOSIT);
        System.out.println("========================================================");
        useEnumType(TransactionTypeEnum.WITHDRAW);
        System.out.println("========================================================");
        useEnumType(TransactionTypeEnum.PAYMENT);
        System.out.println("========================================================");
        useEnumType(TransactionTypeEnum.TRANSFER);
        System.out.println("========================================================");
        useEnumType(TransactionTypeEnum.OTHER);
        //useEnumType(aaaaa); //enum type disinda deger girilemez CTE

    }

    public static void useNonEnumVariable(int n) {

        //        if(transactionType.getCode()==10){
//            System.out.println("Para yatırılıyor...");
//        }

        //ordinal kullanmanın riski? güncellemede sıra değişebilir.

//         if(transactionType.ordinal()==0){
//             System.out.println("Para yatırılıyor...");
//         }



        if (n == TransactionTypeConstant.DEPOSIT) {
            System.out.println("Para yatırılıyor...");
        } else if (n == TransactionTypeConstant.WITHDRAW) {
            System.out.println("Para çekiliyor...");
        } else if (n == TransactionTypeConstant.TRANSFER) {
            System.out.println("Para transfer ediliyor...");
        } else if (n == TransactionTypeConstant.PAYMENT) {
            System.out.println("Ödeme gerçekleşiyor...");
        } else if (n == TransactionTypeConstant.OTHER) {
            System.out.println("Diğer işlemler...");
        }
    }



    public static void useEnumType(TransactionTypeEnum transactionType) {
        if (transactionType == TransactionTypeEnum.DEPOSIT) {
            System.out.println("Para yatırılıyor...");
        } else if (transactionType == TransactionTypeEnum.WITHDRAW) {
            System.out.println("Para çekiliyor...");
        } else if (transactionType == TransactionTypeEnum.TRANSFER) {
            System.out.println("Para transfer ediliyor...");
        } else if (transactionType == TransactionTypeEnum.PAYMENT) {
            System.out.println("Ödeme gerçekleşiyor...");
        } else if (transactionType == TransactionTypeEnum.OTHER) {
            System.out.println("Diğer işlemler...");
        }

        System.out.println("Enum name:"+transactionType.name());
        System.out.println("Enum sirasi:"+transactionType.ordinal());
    }


}
