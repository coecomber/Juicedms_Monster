package com.Herwaarden.Monster.Logic;

import com.Herwaarden.Monster.DAL.Interface.Repositories.IMonsterRepository;
import com.Herwaarden.Monster.Factory.MonsterFactory;
import com.Herwaarden.Monster.Model.MonsterModel;

public class MonsterLogic {
    private IMonsterRepository monsterRepository;

    public MonsterLogic(){
        monsterRepository = new MonsterFactory().getMonsterSQLRepository();
    }

    public MonsterModel getMonsterModelByFloorId(int floorId){
        return monsterRepository.getMonsterByFloor(floorId);
    }
}
