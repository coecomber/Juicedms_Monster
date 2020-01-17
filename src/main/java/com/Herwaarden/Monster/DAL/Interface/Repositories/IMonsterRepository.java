package com.Herwaarden.Monster.DAL.Interface.Repositories;

import com.Herwaarden.Monster.Model.MonsterModel;

public interface IMonsterRepository {
    MonsterModel getMonsterByFloor(int floor);
}
