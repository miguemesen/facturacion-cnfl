package tec.fc.app.domain;

public class Tarjeta implements Entity{

    private Integer id;
    private long cardNumber;
    private Integer ownerId;
    private double saldo;

    public Tarjeta(Integer id, long cardNumber, Integer ownerId, double saldo) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.ownerId = ownerId;
        this.saldo = saldo;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
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
