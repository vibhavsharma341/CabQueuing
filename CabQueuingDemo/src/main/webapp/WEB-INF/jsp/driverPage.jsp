<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<script>

function waiting(driverId){
window.location = '/waiting?driverId='+driverId;
}

function ongoing(){
window.location = '/ongoing';
}

function completed(){
window.location = '/completed';
}

</script>

<form action="/refresh">
  <input type="submit" value="Refresh">
</form> 

<nav class="navbar navbar-default">
  <div class="container-fluid">
    
    <ul class="nav navbar-nav">
      <li><button onClick="waiting(${driverId})">Waiting</button></li>
      <li><button onClick="ongoing()">Ongoing</button></li>
      <li><button onClick="completed()">Completed</button></li>
    </ul>
  </div>
</nav>

</body>
</html>
