import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public class SpecialImdbInfo {

    @JsonProperty("Title") String title;

    @JsonProperty("Year") String year;

    @JsonProperty("Rated") String rated;

    @JsonProperty("Released") String released;

    @JsonProperty("Runtime") String runtime;

    @JsonProperty("Genre") String genre;

    @JsonProperty("Director") String director;

    @JsonProperty("Writer") String writer;

    @JsonProperty("Actors") String actors;

    @JsonProperty("Plot") String plot;

    @JsonProperty("Language") String language;

    @JsonProperty("Country") String country;

    @JsonProperty("Awards") String awards;

    @JsonProperty("Poster") String poster;

    @JsonProperty("Ratings") Ratings [] ratings;

    @JsonProperty("Metascore") String metascore;

    @JsonProperty("imdbRating") String imdbRating;

    @JsonProperty("imdbVotes") String imdbVotes;

    @JsonProperty("imdbID") String imdbId;

    @JsonProperty("Type") String type;

    @JsonProperty("DVD") String dvd;

    @JsonProperty("BoxOffice") String box;

    @JsonProperty("Production") String production;

    @JsonProperty("Website") String website;

    @JsonProperty("Response") String response;


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("SpecialImdbInfo{");
        sb.append("title='").append(title).append('\'');
        sb.append(", year='").append(year).append('\'');
        sb.append(", rated='").append(rated).append('\'');
        sb.append(", released='").append(released).append('\'');
        sb.append(", runtime='").append(runtime).append('\'');
        sb.append(", genre='").append(genre).append('\'');
        sb.append(", director='").append(director).append('\'');
        sb.append(", writer='").append(writer).append('\'');
        sb.append(", actors='").append(actors).append('\'');
        sb.append(", plot='").append(plot).append('\'');
        sb.append(", language='").append(language).append('\'');
        sb.append(", country='").append(country).append('\'');
        sb.append(", awards='").append(awards).append('\'');
        sb.append(", poster='").append(poster).append('\'');
        sb.append(", ratings=").append(ratings == null ? "null" : Arrays.asList(ratings).toString());
        sb.append(", metascore='").append(metascore).append('\'');
        sb.append(", imdbRating='").append(imdbRating).append('\'');
        sb.append(", imdbVotes='").append(imdbVotes).append('\'');
        sb.append(", imdbId='").append(imdbId).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append(", dvd='").append(dvd).append('\'');
        sb.append(", box='").append(box).append('\'');
        sb.append(", production='").append(production).append('\'');
        sb.append(", website='").append(website).append('\'');
        sb.append(", response='").append(response).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
