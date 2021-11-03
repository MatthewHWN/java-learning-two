import java.math.BigDecimal;

public class Basket {

    private Item[] basketContents = new Item[3];
    private int itemsAdded = 0;

    public Basket() {}
    public Basket(int capacity) {
        this.basketContents = new Item[capacity];
    }
    public boolean isFull = false;

    public void checkCapacity() {
        this.isFull = this.itemsAdded == this.basketContents.length;
    }

    public int getCapacity() {
        return this.basketContents.length;
    }

    public void addItemChecker(Item newItem) {
        this.checkCapacity();
        if(!isFull) {
            addItem(newItem);
        }
    }

    private void addItem(Item newItem) {
        for (int i = 0, j = this.basketContents.length; i <= j; i++) {
            if(!checkDuplicate(this.basketContents[i], newItem)) {
                if (this.basketContents[i] == null) {
                    this.basketContents[i] = newItem;
                    this.itemsAdded++;
                    return;
                }
            }
        }
    }

    public Item[] getBasketContents() {
        return this.basketContents;
    }

    public boolean removeItem(Item itemToRemove) {
        for (int i = 0, j = this.basketContents.length; i < j; i++) {
            try {
                if (this.basketContents[i].equals(itemToRemove)) {
                    this.basketContents[i] = null;
                    return true;
                }
            } catch (NullPointerException nullPointerException) {
                return false;
            }
        }
        return false;
    }

    public boolean checkDuplicate(Item inBasket, Item newItem) {
        try {
            return inBasket.equals(newItem);
        } catch (NullPointerException nullPointerException) {
            return false;
        }

    }

    public BigDecimal getTotal() {
        BigDecimal workingTotal = new BigDecimal(0.00);
        for(int i = 0, j = this.basketContents.length; i < j; i++){
            if(this.basketContents[i] != null) {
                workingTotal = workingTotal.add(this.basketContents[i].getPrice());
            }
        }
        return workingTotal;
    }
}
