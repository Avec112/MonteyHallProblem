public class Door {
    private String doorNumber;
    private boolean price;
    private boolean picked;

    public Door(String doorNumber) {
        this.doorNumber = doorNumber;
    }

    public boolean isPrice() {
        return price;
    }

    public void setPrice(boolean price) {
        this.price = price;
    }

    public boolean isPicked() {
        return picked;
    }

    public void setPicked(boolean picked) {
        this.picked = picked;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(doorNumber);
        return sb.toString();
    }
}
