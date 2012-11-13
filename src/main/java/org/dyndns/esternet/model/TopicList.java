package org.dyndns.esternet.model;

import java.util.ArrayList;
import java.util.List;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class TopicList {

	@DatabaseField(generatedId=true)
    private int id;
    
    @DatabaseField
    private String name;
    
    @ForeignCollectionField
    private ForeignCollection<TopicItem> items;

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

    public void setItems(ForeignCollection<TopicItem> items) {
        this.items = items;
    }

    public List<TopicItem> getItems() {
        ArrayList<TopicItem> itemList = new ArrayList<TopicItem>();
        for (TopicItem item : items) {
            itemList.add(item);
        }
        return itemList;
    }
}
