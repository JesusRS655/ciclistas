package application.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import application.configuration.ConfigClass;
import application.entity.Team;
import application.model.TeamModel;
import application.repository.TeamRepository;
import application.service.TeamService;

@Service("teamServiceImpl")
public class TeamServiceImpl implements TeamService {

	@Autowired
	@Qualifier("teamRepository")
	private TeamRepository teamRepository;

	@Autowired
	@Qualifier("configClass")
	private ConfigClass config;

	@Override
	public List<TeamModel> listTeams() {
		List<Team> tList = teamRepository.findAll();
		List<TeamModel> tModelList = new ArrayList<>();
		for (Team t : tList) {
			TeamModel tModel = transform(t);
			tModelList.add(tModel);
		}
		List<TeamModel> orderList = tModelList.stream().sorted((t1, t2) -> t1.getTeamname().compareTo(t2.getTeamname()))
				.collect(Collectors.toList());
		return orderList;
	}

	@Override
	public TeamModel addTeam(TeamModel teamModel) {
		Team team = transform(teamModel);
		return transform(teamRepository.save(team));
	}

	@Override
	public int removeTeam(String teamname) {
		teamRepository.deleteById(teamname);
		return 0;
	}

	@Override
	public TeamModel updateTeam(TeamModel teamModel) {
		Team team = transform(teamModel);
		return transform(teamRepository.save(team));
	}

	@Override
	public Team transform(TeamModel teamModel) {
		return config.mapper().map(teamModel, Team.class);
	}

	@Override
	public TeamModel transform(Team team) {
		return config.mapper().map(team, TeamModel.class);
	}
}
