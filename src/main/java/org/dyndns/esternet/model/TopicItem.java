package org.dyndns.esternet.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class TopicItem {
    @DatabaseField(generatedId=true)
    private int id;
    
    @DatabaseField
    private String imgViewIconID;
    
    @DatabaseField
    private String name;

    @DatabaseField
    private String imgViewContentDescription;

    @DatabaseField(foreign=true,foreignAutoRefresh=true)
    private TopicList list;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setList(TopicList list) {
        this.list = list;
    }

	public TopicList getList() {
        return list;
    }

    public void setImgViewContentDescription(String description) {
        this.imgViewContentDescription = description;
    }

    public String getImgViewContentDescription() {
        return imgViewContentDescription;
    }
    
    public String getImgViewIconID() {
		return imgViewIconID;
	}

	public void setImgViewIconID(String imgViewIconID) {
		this.imgViewIconID = imgViewIconID;
	}

    
}
