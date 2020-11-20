public class Bank {
    private String bankName;
    private Address bankAddress;

    public Bank(String bankName, Address bankAddress) {
        this.bankName = bankName;
        this.bankAddress = bankAddress;
    }

    public String toString() {
        return "Bank [Bank Name= " + bankName + ", Bank " + bankAddress + "]";
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Address getBankAddress() {
        return bankAddress;
    }

    public void setBankAddress(Address bankAddress) {
        this.bankAddress = bankAddress;
    }
}
