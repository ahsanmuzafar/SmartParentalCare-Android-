package com.example.smaretparentalcare;

public class ListData {
	 
    String childName;
    String childLocatoin;
    String childStats;
    int imgResId;

    
    public String getStats() {
        return childStats;
}

public void setStats(String description) {
        childStats = description;
}

    
    
    public String getChildName() {
            return childName;
    }

    public void setChildName(String description) {
            childName = description;
    }

    public String getChildLocatio() {
            return childLocatoin;
    }

    public void setChildLocation(String title) {
            this.childLocatoin = title;
    }

    public int getImgResId() {
            return imgResId;
    }

    public void setImgResId(int imgResId) {
            this.imgResId = imgResId;
    }

}
