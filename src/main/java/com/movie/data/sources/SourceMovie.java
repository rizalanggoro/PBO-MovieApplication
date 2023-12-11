/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.movie.data.sources;

import com.movie.domain.models.Movie;
import java.util.List;

/**
 *
 * @author user
 */
public class SourceMovie {

    public static List<Movie> list = List.of(
            new Movie(
                    "The Shawshank Redemption",
                    "Framed in the 1940s for the double murder of his wife and her lover, upstanding banker Andy Dufresne begins a new life at the Shawshank prison, where he puts his accounting skills to work for an amoral warden. During his long stretch in prison, Dufresne comes to be admired by the other inmates -- including an older prisoner named Red -- for his integrity and unquenchable sense of hope.",
                    "shawshank.jpg",
                    75000
            ),
            new Movie(
                    "The Godfather",
                    "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.",
                    "godfather.jpg",
                    75000
            ),
            new Movie(
                    "The Dark Knight",
                    "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.",
                    "darkknight.jpg",
                    75000
            ),
            new Movie(
                    "Fight Club",
                    "An insomniac office worker and a devil-may-care soap maker form an underground fight club that evolves into much more.",
                    "fightclub.jpg",
                    75000
            ),
            new Movie(
                    "Pulp Fiction",
                    "The lives of two mob hitmen, a boxer, a gangster's wife, and a pair of diner bandits intertwine in four tales of violence and redemption.",
                    "pulpfiction.jpg",
                    75000
            ),
            new Movie(
                    "Forrest Gump",
                    "The presidencies of Kennedy and Johnson, the Vietnam War, the Watergate scandal and other historical events unfold from the perspective of an Alabama man with an IQ of 75, whose only desire is to be reunited with his childhood sweetheart.",
                    "forrestgump.jpg",
                    75000
            ),
            new Movie(
                    "Inception",
                    "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.",
                    "inception.jpg",
                    75000
            ),
            new Movie(
                    "The Matrix",
                    "A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers.",
                    "matrix.jpg",
                    75000
            ),
            new Movie(
                    "Interstellar",
                    "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.",
                    "interstellar.jpg",
                    75000
            ),
            new Movie(
                    "The Lion King",
                    "A Lion cub crown prince is tricked by a treacherous uncle into thinking he caused his father's death and flees into exile in despair, only to learn in adulthood his identity and his responsibilities.",
                    "lionking.jpg",
                    75000
            )
    );
}
