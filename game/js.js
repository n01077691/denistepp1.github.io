/**
 * This is a basic javascript implementation of the game Battleship. When the
 * page is loaded, three ships are randomly placed on the board, either 
 * vertically or horizontally. The ships do not overlap.
 * 
 * @author Denis Stepanov
 * @version March 25th, 2016.
 */

var area = [
    [0, 0, 0, 0, 0, 0, 0], 
    [0, 0, 0, 0, 0, 0, 0], 
    [0, 0, 0, 0, 0, 0, 0], 
    [0, 0, 0, 0, 0, 0, 0], 
    [0, 0, 0, 0, 0, 0, 0], 
    [0, 0, 0, 0, 0, 0, 0], 
    [0, 0, 0, 0, 0, 0, 0], 
];

var letters = 'abcdefg';
var shotCount = 0;
var ships = 0;
var hits = 0;
var remainingSquares = 0;

placeShip(3);
console.table(area);
//document.getElementById('fireButton').onclick = fire;

//to do: check clicked cell



/**
 * Places ships randomly on the board.
 * @param {Number} numShips The number of ships to place.
 */

function placeShip(numShips) {
  
  while (ships < numShips) {
    var row = Math.floor(Math.random() * 7);
    var column = Math.floor(Math.random() * 7);
    var orientation = Math.random() > 0.5 ? 1 : 0; // 1 = horizontal

    if (orientation === 1 && horizontalFree([column, row], ships + 2)) {
      for (let i = 0; i < ships + 2; i++) {
        area[row][column + i] = ships + 2;
        remainingSquares++;
      }
      ships++;
    } else if (orientation === 0 && verticalFree([column, row], ships + 2)) {
      for (let i = 0; i < ships + 2; i++) {
        area[row + i][column] = ships + 2;
        remainingSquares++;
      }
      ships++;
    }
  }
}


/**
 * Checks if the proposed placement of a ship is adjacent to any other ships,
 * which is not allowed in the rules of Battleship.
 * @param {Number[]} startCoordinate An array of coordinates in [x, y] format.
 * @param {Number} length The length of the ship to be checked.
 * @return {Boolean} True if ship can be placed, false otherwise.
 */
function horizontalFree(startCoordinate, length) {
  var x = startCoordinate[0];
  var y = startCoordinate[1];
  
  if (x + length > area.length - 1 || area[y][x] !== 0) {
    return false;
  }
  
  var test = area[y].slice(area[y][x - 1] !== undefined ? x - 1 : 0,
                           area[y][x + length + 1] !== undefined ? x + length + 1 : 0);
  
  for (var i = x; i < x + length; i++) {
    test.push(area[y - 1] ? area[y - 1][i] : 0);
    test.push(area[y + 1] ? area[y + 1][i] : 0);
  }
  return !test.filter(a => a > 0).length;
}


/**
 * Checks if the proposed placement of a ship is adjacent to any other ships.
 * @param {Number[]} startCoordinate An array of coordinates in [x, y] format.
 * @param {Number} length The length of the ship to be checked.
 * @return {Boolean} True if the ship can be placed, false otherwise.
 */
function verticalFree(startCoordinate, length) {
  var x = startCoordinate[0];
  var y = startCoordinate[1];
  
  if (y + length > area.length - 1) { //ship is too long to fit at this coord
    return false;
  }
  
  var test = [];
  
  test.push(area[y - 1] ? area[y - 1][x] : 0); // secure against 'undefined'
  for (var i = y; i < y + length; i++) {
    test.push(area[i][x - 1]);
    test.push(area[i][x]);
    test.push(area[i][x + 1]);
  }
  test.push(area[y + length] ? area[y + length][x] : 0);
  
  return !test.filter(a => a > 0).length;
}


/** Takes input from webpage as the coordinate to fire on.**/
 
function fire(event) {
    cell = event;
    cellClicked = event.currentTarget.id;
  

      var coordinate = cellClicked.split('');
    
      if (hit(coordinate, cell)) {
        cell.srcElement.classList.add('hit');
      } else {
        cell.srcElement.classList.add('miss');
      }
      shotCount++;
    
    
  if (!remainingSquares) {
      finish(shotCount, hits);
  }
}



/**
 * Determines whether a shot hits a ship.
 * @param {Number[]} coordinate The coordinates on 'area' to check.
 * @return {Boolean} True if hit, false otherwise.
 */
function hit(coordinate, cell) {
  var returnVal = false;
    console.log(cell.currentTarget);
  
  if (area[coordinate[0]][coordinate[1]] > 1) {
    returnVal = true;

    area[coordinate[0]][coordinate[1]] = -1;
    hits++;
    remainingSquares--;
  
  } else if(area[coordinate[0]][coordinate[1]] < 0) {
    cell.innerHTML = "hello world";
    returnVal = true;
  } 
  return returnVal;
}


/**
 * Function to finish the game and count accuracy
 * @param {Number} shots Tries taken to sunk all the ships
 * @param {Number} hits  Amount of squares hit where ships were placed
*/
 
function finish(shots, hits) { 
    //set accuracy 
    accuracy = (hits / shots) * 100;
    
    //get navigation elements
    document.getElementById("info").classList.add("finish_class");
    var nav_finish = document.getElementById("myNav");
    var nav_info = document.getElementById("info");

    //close button    
    var close_btn = document.getElementById("closebtn");
    close_btn.onclick = function end(){location.reload()};
    close_btn.innerHTML = "Restart!";

    //get color changing elements
    document.getElementById("accuracy_html").classList.add("finish_class");
    document.getElementById("shots_html").classList.add("finish_class");
    document.getElementById("accuracy_html").value = accuracy.toFixed(2);
    document.getElementById("shots_html").value = shots;

    
    document.getElementById("info").classList.remove("finish_class");
    nav_info.innerHTML = "Congratulations! You have destroyed all the ships!\n You took " + document.getElementById("shots_html").value + " shots and your accuracy is " + accuracy_html.value + "%\nPush restart to play again!";

    nav_finish.style.height = "100%";
    
}
