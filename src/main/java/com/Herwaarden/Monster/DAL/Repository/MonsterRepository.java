package com.Herwaarden.Monster.DAL.Repository;

import com.Herwaarden.Monster.DAL.Interface.Context.IMonsterContext;
import com.Herwaarden.Monster.DAL.Interface.Repositories.IMonsterRepository;
import com.Herwaarden.Monster.Model.MonsterModel;

public class MonsterRepository implements IMonsterRepository {

    private IMonsterContext monsterContext;

    public MonsterRepository(IMonsterContext context){
        monsterContext = context;
    }

    @Override
    public MonsterModel getMonsterByFloor(int floor) {
        return monsterContext.getMonsterByFloor(floor);
    }
}
