package com.auttmme.moviecatalogue.utils

import com.auttmme.moviecatalogue.data.source.local.entity.MovieEntity
import com.auttmme.moviecatalogue.data.source.local.entity.TvShowEntity
import com.auttmme.moviecatalogue.data.source.remote.response.MovieResponse
import com.auttmme.moviecatalogue.data.source.remote.response.TvShowResponse

object DataDummy {

    fun generateDummyMovies(): ArrayList<MovieEntity> {
        val movies = ArrayList<MovieEntity>()

        movies.add(
            MovieEntity(
            332562,
                "A Star Is Born",
                "Seasoned musician Jackson Maine discovers and falls in love with struggling artist Ally. She has just about given up on her dream to make it big as a singer until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                2018,
            "https://www.themoviedb.org/t/p/w1280/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg",
                "Drama, Romance",
            "2h 16m"
        )
        )
        movies.add(
            MovieEntity(
                399579,
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                2019,
            "https://www.themoviedb.org/t/p/w1280/xRWht48C2V8XNfzvPehyClOvDni.jpg",
                "Action, Sci-Fi",
            "2h 2m"
        )
        )
        movies.add(
            MovieEntity(
                297802,
                "Aquaman",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                2018,
            "https://www.themoviedb.org/t/p/w1280/xLPffWMhMj1l50ND3KchMjYoKmE.jpg",
                "Action, Adventure, Fantasy",
            "2h 23m"
        )
        )
        movies.add(
            MovieEntity(
                424694,
                "Bohemian Rhapsody",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                2018,
            "https://www.themoviedb.org/t/p/w1280/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg",
                "Music, Drama, History",
            "2h 15m"
        )
        )
        movies.add(
            MovieEntity(
                438650,
                "Cold Pursuit",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                2019,
            "https://www.themoviedb.org/t/p/w1280/hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg",
                "Action, Crime",
            "1h 59m"
        )
        )
        movies.add(
            MovieEntity(
                480530,
                "Creed II",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                2018,
            "https://www.themoviedb.org/t/p/w1280/v3QyboWRoA4O9RbcsqH8tJMe8EB.jpg",
                "Drama",
            "2h 10m"
        )
        )
        movies.add(
            MovieEntity(
                338952,
                "Fantastic Beasts: The Crimes of Grindelwald",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                2018,
            "https://www.themoviedb.org/t/p/w1280/fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg",
                "Adventure, Fantasy",
            "2h 14m"
        )
        )
        movies.add(
            MovieEntity(
                450465,
                "Glass",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                2019,
            "https://www.themoviedb.org/t/p/w1280/fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg",
                "Thriller, Drama",
            "2h 9m"
        )
        )
        movies.add(
            MovieEntity(
                166428,
                "How to Train Your Dragon: The Hidden World",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                2019,
            "https://www.themoviedb.org/t/p/w1280/bCYRgsT0Kndh23a6kHazBdXWCn1.jpg",
                "Animation, Adventure",
            "1h 44m"
        )
        )
        movies.add(
            MovieEntity(
                299536,
                "Avengers: Infinity War",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                2018,
            "https://www.themoviedb.org/t/p/w1280/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
                "Action, Sci-Fi",
            "2h 29m"
        )
        )
        movies.add(
            MovieEntity(
                457136,
                "Mary Queen of Scots",
                "In 1561, Mary Stuart, widow of the King of France, returns to Scotland, reclaims her rightful throne and menaces the future of Queen Elizabeth I as ruler of England, because she has a legitimate claim to the English throne. Betrayals, rebellions, conspiracies and their own life choices imperil both Queens. They experience the bitter cost of power, until their tragic fate is finally fulfilled.",
                2018,
            "https://www.themoviedb.org/t/p/w1280/b5RMzLAyq5QW6GtN9sIeAEMLlBI.jpg",
                "Drama, History",
            "2h 4m"
        )
        )
        movies.add(
            MovieEntity(
                450001,
                "Master Z: Ip Man Legacy",
                "Following his defeat by Master Ip, Cheung Tin Chi tries to make a life with his young son in Hong Kong, waiting tables at a bar that caters to expats. But it's not long before the mix of foreigners, money, and triad leaders draw him once again to the fight.",
                2018,
            "https://www.themoviedb.org/t/p/w1280/6VxEvOF7QDovsG6ro9OVyjH07LF.jpg",
                "Action",
            "1h 47m"
        )
        )
        movies.add(
            MovieEntity(
                428078,
                "Mortal Engines",
                "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.",
                2018,
            "https://www.themoviedb.org/t/p/w1280/gLhYg9NIvIPKVRTtvzCWnp1qJWG.jpg",
                "Adventure, Sci-Fi",
            "2h 9m"
        )
        )
        movies.add(
            MovieEntity(
                404368,
                "Ralph Breaks the Internet",
                "Video game bad guy Ralph and fellow misfit Vanellope von Schweetz must risk it all by traveling to the World Wide Web in search of a replacement part to save Vanellope's video game, Sugar Rush. In way over their heads, Ralph and Vanellope rely on the citizens of the internet — the netizens — to help navigate their way, including an entrepreneur named Yesss, who is the head algorithm and the heart and soul of trend-making site BuzzzTube.",
                2018,
            "https://www.themoviedb.org/t/p/w1280/44cb3fCGKUaSxxIjI2ejrgeYfye.jpg",
                "Animation, Adventure, Family",
            "1h 52m"
        )
        )

        return movies
    }

    fun generateDummyTvShows(): ArrayList<TvShowEntity> {
        val tvShows = ArrayList<TvShowEntity>()

        tvShows.add(
            TvShowEntity(
                1412,
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                2019,
            "https://www.themoviedb.org/t/p/w1280/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg",
                8,
                10,
                "Crime, Drama, Mystery"
        )
        )
        tvShows.add(
            TvShowEntity(
                79501,
                "Doom Patrol",
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                2020,
            "https://www.themoviedb.org/t/p/w1280/drlfSCIlMKrEeMPhi8pqY4xGxj.jpg",
                2,
                9,
                "Sci-Fi, Comedy, Drama"
        )
        )
        tvShows.add(
            TvShowEntity(
                46261,
                "Fairy Tail",
                "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
                2018,
            "https://www.themoviedb.org/t/p/w1280/jsYTctFnK8ewomnUgcwhmsTkOum.jpg",
                8,
                51,
                "Anime, Sci-Fi, Action"
        )
        )
        tvShows.add(
            TvShowEntity(
                1434,
                "Family Guy",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                2020,
            "https://www.themoviedb.org/t/p/w1280/eWWCRjBfLyePh2tfZdvNcIvKSJe.jpg",
                19,
                20,
                "Animation, Comedy"
        )
        )
        tvShows.add(
            TvShowEntity(
                60735,
                "The Flash",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                2021,
            "https://www.themoviedb.org/t/p/w1280/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                7,
                18,
                "Drama, Sci-Fi"
        )
        )
        tvShows.add(
            TvShowEntity(
                1399,
                "Game of Thrones",
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                2019,
            "https://www.themoviedb.org/t/p/w1280/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg",
                8,
                6,
                "Sci-Fi, Drama, Action"
        )
        )
        tvShows.add(
            TvShowEntity(
                60708,
                "Gotham",
                "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                2019,
            "https://www.themoviedb.org/t/p/w1280/4XddcRDtnNjYmLRMYpbrhFxsbuq.jpg",
                5,
                12,
                "Drama, Crime, Sci-Fi"
        )
        )
        tvShows.add(
            TvShowEntity(
                1416,
                "Grey's Anatomy",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                2020,
            "https://www.themoviedb.org/t/p/w1280/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
                17,
                16,
                "Drama"
        )
        )
        tvShows.add(
            TvShowEntity(
                4614,
                "NCIS",
                "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position.",
                2020,
            "https://www.themoviedb.org/t/p/w1280/fi8EvaWtL5CvoielOjjVvTr7ux3.jpg",
                18,
                14,
                "Crime, Action, Drama"
        )
        )
        tvShows.add(
            TvShowEntity(
                1622,
                "Supernatural",
                "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way.",
                2019,
            "https://www.themoviedb.org/t/p/w1280/KoYWXbnYuS3b0GyQPkbuexlVK9.jpg",
                15,
                20,
                "Drama, Mystery, Sci-Fi"
        )
        )
        tvShows.add(
            TvShowEntity(
                75006,
                "The Umbrella Academy",
                "A dysfunctional family of superheroes comes together to solve the mystery of their father's death, the threat of the apocalypse and more.",
                2020,
            "https://www.themoviedb.org/t/p/w1280/scZlQQYnDVlnpxFTxaIv2g0BWnL.jpg",
                2,
                10,
                "Action, Sci-Fi, Drama"
        )
        )
        tvShows.add(
            TvShowEntity(
                69050,
                "Riverdale",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                2021,
            "https://www.themoviedb.org/t/p/w1280/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg",
                5,
                11,
                "Mystery, Drama, Crime"
        )
        )

        return tvShows
    }

    fun generateRemoteDummyMovies(): List<MovieResponse> {
        val rMovies = ArrayList<MovieResponse>()

        rMovies.add(MovieResponse(
                332562,
                "A Star Is Born",
                "Seasoned musician Jackson Maine discovers and falls in love with struggling artist Ally. She has just about given up on her dream to make it big as a singer until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                2018,
                "https://www.themoviedb.org/t/p/w1280/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg",
                "Drama, Romance",
                "2h 16m"
        ))

        rMovies.add(MovieResponse(
                399579,
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                2019,
                "https://www.themoviedb.org/t/p/w1280/xRWht48C2V8XNfzvPehyClOvDni.jpg",
                "Action, Sci-Fi",
                "2h 2m"
        ))

        rMovies.add(MovieResponse(
                297802,
                "Aquaman",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                2018,
                "https://www.themoviedb.org/t/p/w1280/xLPffWMhMj1l50ND3KchMjYoKmE.jpg",
                "Action, Adventure, Fantasy",
                "2h 23m"
        ))

        rMovies.add(MovieResponse(
                424694,
                "Bohemian Rhapsody",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                2018,
                "https://www.themoviedb.org/t/p/w1280/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg",
                "Music, Drama, History",
                "2h 15m"
        ))

        rMovies.add(MovieResponse(
                438650,
                "Cold Pursuit",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                2019,
                "https://www.themoviedb.org/t/p/w1280/hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg",
                "Action, Crime",
                "1h 59m"
        ))

        rMovies.add(MovieResponse(
                480530,
                "Creed II",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                2018,
                "https://www.themoviedb.org/t/p/w1280/v3QyboWRoA4O9RbcsqH8tJMe8EB.jpg",
                "Drama",
                "2h 10m"
        ))

        rMovies.add(MovieResponse(
                338952,
                "Fantastic Beasts: The Crimes of Grindelwald",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                2018,
                "https://www.themoviedb.org/t/p/w1280/fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg",
                "Adventure, Fantasy",
                "2h 14m"
        ))

        rMovies.add(MovieResponse(
                450465,
                "Glass",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                2019,
                "https://www.themoviedb.org/t/p/w1280/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg",
                "Thriller, Drama",
                "2h 9m"
        ))

        rMovies.add(MovieResponse(
                166428,
                "How to Train Your Dragon: The Hidden World",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                2019,
                "https://www.themoviedb.org/t/p/w1280/bCYRgsT0Kndh23a6kHazBdXWCn1.jpg",
                "Animation, Adventure",
                "1h 44m"
        ))

        rMovies.add(MovieResponse(
                299536,
                "Avengers: Infinity War",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                2018,
                "https://www.themoviedb.org/t/p/w1280/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
                "Action, Sci-Fi",
                "2h 29m"
        ))

        rMovies.add(MovieResponse(
                457136,
                "Mary Queen of Scots",
                "In 1561, Mary Stuart, widow of the King of France, returns to Scotland, reclaims her rightful throne and menaces the future of Queen Elizabeth I as ruler of England, because she has a legitimate claim to the English throne. Betrayals, rebellions, conspiracies and their own life choices imperil both Queens. They experience the bitter cost of power, until their tragic fate is finally fulfilled.",
                2018,
                "https://www.themoviedb.org/t/p/w1280/b5RMzLAyq5QW6GtN9sIeAEMLlBI.jpg",
                "Drama, History",
                "2h 4m"
        ))

        rMovies.add(MovieResponse(
                450001,
                "Master Z: Ip Man Legacy",
                "Following his defeat by Master Ip, Cheung Tin Chi tries to make a life with his young son in Hong Kong, waiting tables at a bar that caters to expats. But it's not long before the mix of foreigners, money, and triad leaders draw him once again to the fight.",
                2018,
                "https://www.themoviedb.org/t/p/w1280/6VxEvOF7QDovsG6ro9OVyjH07LF.jpg",
                "Action",
                "1h 47m"
        ))

        rMovies.add(MovieResponse(
                428078,
                "Mortal Engines",
                "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.",
                2018,
                "https://www.themoviedb.org/t/p/w1280/gLhYg9NIvIPKVRTtvzCWnp1qJWG.jpg",
                "Adventure, Sci-Fi",
                "2h 9m"
        ))

        rMovies.add(MovieResponse(
                404368,
                "Ralph Breaks the Internet",
                "Video game bad guy Ralph and fellow misfit Vanellope von Schweetz must risk it all by traveling to the World Wide Web in search of a replacement part to save Vanellope's video game, Sugar Rush. In way over their heads, Ralph and Vanellope rely on the citizens of the internet — the netizens — to help navigate their way, including an entrepreneur named Yesss, who is the head algorithm and the heart and soul of trend-making site BuzzzTube.",
                2018,
                "https://www.themoviedb.org/t/p/w1280/44cb3fCGKUaSxxIjI2ejrgeYfye.jpg",
                "Animation, Adventure, Family",
                "1h 52m"
        ))

        return rMovies
    }

    fun generateRemoteDummyTvShows(): List<TvShowResponse> {
        val rTvShows = ArrayList<TvShowResponse>()

        rTvShows.add(TvShowResponse(
                1412,
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                2019,
                "https://www.themoviedb.org/t/p/w1280/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg",
                8,
                10,
                "Crime, Drama, Mystery"
        ))

        rTvShows.add(TvShowResponse(
                79501,
                "Doom Patrol",
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                2020,
                "https://www.themoviedb.org/t/p/w1280/drlfSCIlMKrEeMPhi8pqY4xGxj.jpg",
                2,
                9,
                "Sci-Fi, Comedy, Drama"
        ))

        rTvShows.add(TvShowResponse(
                46261,
                "Fairy Tail",
                "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
                2018,
                "https://www.themoviedb.org/t/p/w1280/jsYTctFnK8ewomnUgcwhmsTkOum.jpg",
                8,
                51,
                "Anime, Sci-Fi, Action"
        ))

        rTvShows.add(TvShowResponse(
                1434,
                "Family Guy",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                2020,
                "https://www.themoviedb.org/t/p/w1280/eWWCRjBfLyePh2tfZdvNcIvKSJe.jpg",
                19,
                20,
                "Animation, Comedy"
        ))

        rTvShows.add(TvShowResponse(
                60735,
                "The Flash",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                2021,
                "https://www.themoviedb.org/t/p/w1280/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                7,
                18,
                "Drama, Sci-Fi"
        ))

        rTvShows.add(TvShowResponse(
                1399,
                "Game of Thrones",
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                2019,
                "https://www.themoviedb.org/t/p/w1280/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg",
                8,
                6,
                "Sci-Fi, Drama, Action"
        ))

        rTvShows.add(TvShowResponse(
                60708,
                "Gotham",
                "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                2019,
                "https://www.themoviedb.org/t/p/w1280/4XddcRDtnNjYmLRMYpbrhFxsbuq.jpg",
                5,
                12,
                "Drama, Crime, Sci-Fi"
        ))

        rTvShows.add(TvShowResponse(
                1416,
                "Grey's Anatomy",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                2020,
                "https://www.themoviedb.org/t/p/w1280/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
                17,
                16,
                "Drama"
        ))

        rTvShows.add(TvShowResponse(
                4614,
                "NCIS",
                "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position.",
                2020,
                "https://www.themoviedb.org/t/p/w1280/fi8EvaWtL5CvoielOjjVvTr7ux3.jpg",
                18,
                14,
                "Crime, Action, Drama"
        ))

        rTvShows.add(TvShowResponse(
                1622,
                "Supernatural",
                "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way.",
                2019,
                "https://www.themoviedb.org/t/p/w1280/KoYWXbnYuS3b0GyQPkbuexlVK9.jpg",
                15,
                20,
                "Drama, Mystery, Sci-Fi"
        ))

        rTvShows.add(TvShowResponse(
                75006,
                "The Umbrella Academy",
                "A dysfunctional family of superheroes comes together to solve the mystery of their father's death, the threat of the apocalypse and more.",
                2020,
                "https://www.themoviedb.org/t/p/w1280/scZlQQYnDVlnpxFTxaIv2g0BWnL.jpg",
                2,
                10,
                "Action, Sci-Fi, Drama"
        ))

        rTvShows.add(TvShowResponse(
                69050,
                "Riverdale",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                2021,
                "https://www.themoviedb.org/t/p/w1280/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg",
                5,
                11,
                "Mystery, Drama, Crime"
        ))

        return rTvShows
    }
}