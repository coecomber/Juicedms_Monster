package com.Herwaarden.Monster;

import com.Herwaarden.Monster.Logic.MonsterLogic;
import com.Herwaarden.Monster.Model.MonsterModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class MonsterApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	//Integration test
	@Test
	void TestGettingMonster() throws Exception {
		MonsterLogic monsterLogic = new MonsterLogic();

		mockMvc.perform(get("/api/public/monster/get/{floorId}", 1)
				.contentType("application/json"));

		MonsterModel monsterModel = monsterLogic.getMonsterModelByFloorId('1');
		assertThat(monsterModel.getFloor()).isAtLeast(0);
	}
}
