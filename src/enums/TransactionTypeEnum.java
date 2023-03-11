package enums;

public enum TransactionTypeEnum {

    DEPOSIT(1),
    WITHDRAW(2),
    TRANSFER(3),
    PAYMENT(4),
    OTHER(5);

    private final int code;

    public int getCode() {
        return code;
    }

    private TransactionTypeEnum(int code) {
        this.code = code;
    }

}
