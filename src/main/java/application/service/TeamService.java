package application.service;

import java.util.List;

import application.entity.Team;
import application.model.TeamModel;

public interface TeamService {

	public abstract List<TeamModel> listTeams();

	public abstract TeamModel addTeam(TeamModel teamModel);

	public abstract int removeTeam(String teamname);

	public TeamModel updateTeam(TeamModel teamModel);

	public abstract Team transform(TeamModel teamModel);

	public abstract TeamModel transform(Team team);

}
