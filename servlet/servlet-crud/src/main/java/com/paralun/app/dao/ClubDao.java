/*
 * Copyright (c) 2016 | James Kusmambang
 * Source : https://github.com/paralun
 */
package com.paralun.app.dao;

import com.paralun.app.model.Club;
import java.util.List;

public interface ClubDao {
    
    public void save(Club club);
    public void update(Club club);
    public void delete(int id);
    public Club getClub(int id);
    public List<Club> getClubs();
}
