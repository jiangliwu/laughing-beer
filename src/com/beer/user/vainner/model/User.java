package com.beer.user.vainner.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_user")
public class User implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;
	
	private String username;
	private String password;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "student_id")
	private String studentId;
	private String gender;
	private int grade;

	@Column(name = "play_game_times")
	private int playGameTimes;
	@Column(name = "last_login_time")
	private Date lastLoginTime;
	@Column(name = "use_tool_times")
	private int useToolTimes;
	@Column(name = "in_game")
	private int inGame;
	@Column(name = "game_room_id")
	private int gameRoomId;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public int getPlayGameTimes() {
		return playGameTimes;
	}

	public void setPlayGameTimes(int playGameTimes) {
		this.playGameTimes = playGameTimes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public int getUseToolTimes() {
		return useToolTimes;
	}

	public void setUseToolTimes(int useToolTimes) {
		this.useToolTimes = useToolTimes;
	}

	public int getInGame() {
		return inGame;
	}

	public void setInGame(int inGame) {
		this.inGame = inGame;
	}

	public int getGameRoomId() {
		return gameRoomId;
	}

	public void setGameRoomId(int gameRoomId) {
		this.gameRoomId = gameRoomId;
	}

}