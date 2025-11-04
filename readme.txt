part of my flavorful use of comments/print statements describes what this game is about, but thats the job of this text file


The story is provided as you play, and at the beginning it asks if you want some lore, which I will put here:
"
The year is 2034. Big tech corporations have gained a higher authority than most worldwide governments, and their fight for AI dominance has led to several wars between the states under their influence. 
Sides have gone nuclear. Billions are gone. You and many others have taken shelter in various bunkers and shelters in secrecy from big tech. 
You have been tasked with operating one of the few remaining rebellion bots to eliminate Grok, the assumed authority of the remaining States in the continent. If you succeed, it would provide a great advance point for the human rebellion.
Take care, plan accordingly, and if you succeed, you will be a renowned hero for the human race. Be not concerned for failure.
"
so relevant to modern society, dont you think? (this is satire if you couldn't tell)

in the story you encounter various different scenes (11 total), most of which only lead to others or provide story. I don't consider them as "cosmetic flavor text" (not all of them at least)
There are three different endings (four, technically):
1: boss fight (Win or lose, both have different outcomes)
2: attempt to defect to the enemy side (you get killed)
3: secret ending requiring a key and a mysterious door

each scene is its own method, it is structured to be an indefinite length, only terminating when the user reaches an ending. They are all dependent on selection structures, so it easily satisfies the 10+ requirement. you can jump between adjacent scenes,
because it's needed for the searching feature. the only scene you cannot return from is the bossfight scene. 
Could've drawn out the journey to it a bit more but i'm outta time (been busy literally the whole week we had the ability to work on this, currenty typing this at 3 am)


i havent had the time to playtest the whole thing, so the spacing might look funky or whatnot. sorry abt that
program only crashes if you input the wrong data type



also, please refrain from using ai generated imagery for you slideshows, its not cool :(

checklist:
8+ scenes
3+ endings
2+ meaningful branches (debatable due to the forward/backward movement abiltiy)

2+ nested conditonals (the whole thing is a hyper nested conditional)
replay while loop
input validation while loop combined with a for loop (scene 8 torture)

health, affects outcome of bossfight
clean use of several variables

(mostly) validated inputs plus formatting
fairly readable structure

extra:
    intro/title screen
    "choice log" (ending text, up to you if you want to count that)

(couldnt find a way to fit difficulty into this D: )

at the bottom of the .java file, my rough planning is shown:
/*
 * planning:
 * 
 * starting scene, branches into main and side
 * 
 * 
 *     main       start      side  
 *                  1
 *       2                    5
 *     3   4        6     8       9
 *                  7          10    11(secret)
 * 
 * endings:
 * 4: boss fight, win or lose 
 * 7: defect to the enemy team, betraying the humans. you still die
 * 11: secret, find key in one of two areas (randomized in a search feature),  discover the power source, disable all ai at the cost of the world electricity grid
 *      search locations: 3 (20%/search, 3 tries), 7 (12.5%/search, 5 tries)
 * secret ending is probability based, but its there 
 */