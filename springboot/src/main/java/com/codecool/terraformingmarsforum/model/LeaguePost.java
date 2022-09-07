package com.codecool.terraformingmarsforum.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;


/**
 * This class is the representation of a league post.
 * When new league detail information is coming from <a href="https://terraforming-mars-leagues.herokuapp.com/">terraforming Mars League</a>
 * , this object has created with the league post details.<br>
 * The Class {@link LeaguePost#description description} field contains the league 'status' information
 * i.e., "Zsu has Started 'Brutal League'".
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class LeaguePost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    //TODO This description field is not used yet. implement it in frontend first.
    String description;
    @ManyToOne
    LeagueDetail leagueDetail;

    @OneToMany
    List<Comment> comments;
}
