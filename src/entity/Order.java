package entity;

/**
 * @author skaarf9
 */
public class Order {
    private int id;
    private boolean dStatus;
    private String dAddress;
    private int dGoods ;
    private int dNum;
    private boolean pStatus;
    private String dTime;

    public Order() {
    }

    public Order(int id, boolean dStatus, String dAddress, int dGoods, int dNum, boolean pStatus, String dTime) {
        this.id = id;
        this.dStatus = dStatus;
        this.dAddress = dAddress;
        this.dGoods = dGoods;
        this.dNum = dNum;
        this.pStatus = pStatus;
        this.dTime = dTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isdStatus() {
        return dStatus;
    }

    public void setdStatus(boolean dStatus) {
        this.dStatus = dStatus;
    }

    public String getdAddress() {
        return dAddress;
    }

    public void setdAddress(String dAddress) {
        this.dAddress = dAddress;
    }

    public int getdGoods() {
        return dGoods;
    }

    public void setdGoods(int dGoods) {
        this.dGoods = dGoods;
    }

    public int getdNum() {
        return dNum;
    }

    public void setdNum(int dNum) {
        this.dNum = dNum;
    }

    public boolean ispStatus() {
        return pStatus;
    }

    public void setpStatus(boolean pStatus) {
        this.pStatus = pStatus;
    }

    public String getdTime() {
        return dTime;
    }

    public void setdTime(String dTime) {
        this.dTime = dTime;
    }
}
