(function($){

    var bracketData = {
        teams : [
            ["Team 1", "Team 2"], /* first matchup */
            ["Team 3", "Team 4"]  /* second matchup */
        ],
        results : [
            [[1,2], [3,4]],       /* first round */
            [[4,6], [2,1]]        /* second round */
        ]
    }

    $(function() {
        $('#bracket .display-bracket').bracket({
            init: bracketData /* data to initialize the bracket with */ })
    })
})(jQuery); // end of jQuery name space
