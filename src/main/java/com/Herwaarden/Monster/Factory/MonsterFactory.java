package com.Herwaarden.Monster.Factory;

import com.Herwaarden.Monster.DAL.Context.MonsterContextSQL;
import com.Herwaarden.Monster.DAL.Interface.Repositories.IMonsterRepository;
import com.Herwaarden.Monster.DAL.Repository.MonsterRepository;

public class MonsterFactory {
    public MonsterRepository monsterRepository;

    public IMonsterRepository getMonsterSQLRepository(){
        monsterRepository = new MonsterRepository(new MonsterContextSQL());
        return monsterRepository;
    }
}
