package com.Herwaarden.Monster.DAL.Interface.Context;

import com.Herwaarden.Monster.Model.MonsterModel;

public interface IMonsterContext {
    MonsterModel getMonsterByFloor(int floor);
}
