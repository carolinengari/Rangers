$(document).ready(function(){
// Animations init
new WOW().init();

var typed=new Typed(`#type`,{
     strings:[" Ranger Assist "," An application that allows Rangers to record wildlife sightings in the area. "],
     backSpeed:70,
     typeSpeed:80,
     smartBackspace:true,
     loop: true,
   })
   var typed =new Typed(`#msg`,{
        strings:[" Animal sighting recorded "],
        backSpeed:70,
        typeSpeed:80,
        smartBackspace:true,
      })
})


function secondClick(){
timer:4000
Swal.fire(
  'Open?',
)
}

function firstClick(){
timer:4000
Swal.fire(
  'Make endangered?',

)
}
function thirdClick(){
timer:4000
Swal.fire(
  'Record Sighting?',

)
}


// Animations init
new WOW().init();