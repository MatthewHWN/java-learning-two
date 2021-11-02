import java.util.Arrays;

public class Basket {

    private Item[] basketContents = new Item[3];

    public Basket() {}



    public int capacity = 2;
    public boolean isFull = false;

    public void checkCapacity() {
//        this.isFull = this.basketContents.length >= this.capacity;
//        System.out.println(this.basketContents.toString());
        for(int i = 0, j = this.basketContents.length; i < j; i++) {
            if(this.basketContents[i] == null && i >= this.capacity--) {
                this.isFull = true;
            }
            else {
                this.isFull = false;
            }
            return;
        }
    }

    public void addItem(Item newItem) {
        this.checkCapacity();
        if(!isFull) {
            for (int i = 0, j = this.basketContents.length; i <= j; i++) {
                if (this.basketContents[i] == null) {
                    this.basketContents[i] = newItem;
                    return;
                }
            }
        }
        else {
            System.out.println("Basket is full.");
        }
    }

    public Item[] getBasketContents() {
        return this.basketContents;
    }

    public boolean removeItem(Item itemToRemove) {
        for (int i = 0, j = this.basketContents.length; i < j; i++) {
            try {
                // add a null check to prevent the NullPointerException from being thrown, then refactored to use a try catch block to catch the null exception and return false.
                if (/*this.basketContents[i] != null &&*/ this.basketContents[i].equals(itemToRemove)) {
                    this.basketContents[i] = null;
                    return true;
                }
            } catch (NullPointerException nullPointerException) {
                return false;
            }
        }
        return false;
    }
}
