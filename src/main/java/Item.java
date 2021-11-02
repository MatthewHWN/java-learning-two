import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;

public class Item {

    private UUID itemID;
    private BigDecimal price = new BigDecimal(2.55).setScale(2, RoundingMode.HALF_UP);

    public Item() {this.itemID = UUID.randomUUID(); }

    public UUID getID() {return this.itemID; }

    public BigDecimal getPrice() {
        return price;
    }
}
