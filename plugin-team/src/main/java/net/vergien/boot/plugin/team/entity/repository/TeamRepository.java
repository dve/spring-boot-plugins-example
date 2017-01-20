package net.vergien.boot.plugin.team.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.vergien.boot.plugin.team.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {

}
