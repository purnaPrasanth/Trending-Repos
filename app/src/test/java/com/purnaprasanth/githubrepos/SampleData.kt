package com.purnaprasanth.githubrepos

import com.purnaprasanth.githubrepos.data.model.TrendingRepo
import com.purnaprasanth.githubrepos.github.data.BuiltBy
import com.purnaprasanth.githubrepos.github.data.GithubTrendingRepo

/**
 * Created by Purna on 2019-09-21 as a part of GithubRepos
 **/

val githubRepo1 = GithubTrendingRepo(
    author = "dylanaraps",
    name = "pure-bash-bible",
    avatar = "https://github.com/dylanaraps.png",
    url = "https://github.com/dylanaraps.png",
    description = "\uD83D\uDCD6 A collection of pure bash alternatives to external processes.",
    language = "Shell",
    languageColor = "#89e051",
    stars = 19073,
    forks = 1385,
    currentPeriodStars = 1074,
    builtBy = listOf(
        BuiltBy(
            username = "dylanaraps",
            href = "https://github.com/dylanaraps",
            avatar = "https://avatars3.githubusercontent.com/u/6799467"
        ),
        BuiltBy(
            username = "paxperscientiam",
            href = "https://github.com/paxperscientiam",
            avatar = "https://avatars2.githubusercontent.com/u/7539871"
        )
    )
)

val githubRepo2 = GithubTrendingRepo(
    author = "developers-against-repressions",
    name = "case-212",
    avatar = "https://github.com/developers-against-repressions.png",
    url = "https://github.com/developers-against-repressions/case-212",
    description = "Открытое письмо специалистов IT-индустрии в защиту фигурантов «московского дела»",
    language = "Python",
    languageColor = "#3572A5",
    stars = 1182,
    forks = 2149,
    currentPeriodStars = 226,
    builtBy = listOf(
        BuiltBy(
            username = "hookzof",
            href = "https://github.com/hookzof",
            avatar = "https://avatars2.githubusercontent.com/u/22233835"
        ),
        BuiltBy(
            username = "fersel",
            href = "https://github.com/fersel",
            avatar = "https://avatars1.githubusercontent.com/u/26058751"
        )
    )
)

val trendingRepo1 = TrendingRepo(
    author = "dylanaraps",
    name = "pure-bash-bible",
    avatar = "https://github.com/dylanaraps.png",
    url = "https://github.com/dylanaraps.png",
    description = "\uD83D\uDCD6 A collection of pure bash alternatives to external processes.",
    stars = 19073,
    fork = 1385,
    language = "Shell",
    languageColor = "#89e051"
)

val trendingRepo2 = TrendingRepo(
    author = "developers-against-repressions",
    name = "case-212",
    avatar = "https://github.com/developers-against-repressions.png",
    url = "https://github.com/developers-against-repressions/case-212",
    description = "Открытое письмо специалистов IT-индустрии в защиту фигурантов «московского дела»",
    stars = 1182,
    fork = 2149,
    language = "Python",
    languageColor = "#3572A5"
)