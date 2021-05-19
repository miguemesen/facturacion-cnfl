package tec.fc.app.domain;

public class Tarjeta implements Entity{

    private Integer id;
    private long cardNumber;
    private Integer ownerId;
    private int saldo;

    public Tarjeta(Integer id, long cardNumber, Integer ownerId, int saldo) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.ownerId = ownerId;
        this.saldo = saldo;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public Integer getId() {
        return id;
    }
}
