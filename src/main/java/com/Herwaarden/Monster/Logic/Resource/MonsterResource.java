package com.Herwaarden.Monster.Logic.Resource;

import com.Herwaarden.Monster.Logic.MonsterLogic;
import com.Herwaarden.Monster.Model.MonsterModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class MonsterResource {

    // How to make REST at least level 2:
    // https://martinfowler.com/articles/richardsonMaturityModel.html#level0

    @CrossOrigin(origins = {"http://localhost:9000","http://217.101.44.31:9000"})
    @GetMapping("/public/monster/get/{floorId}")
    public MonsterModel getMonsterModelByFloorId(@PathVariable("floorId") int floorId){
        MonsterLogic monsterLogic = new MonsterLogic();

        return monsterLogic.getMonsterModelByFloorId(floorId);
    }

}
