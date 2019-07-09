<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu Page</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<style type="text/css">
.navbar {
    padding-top: 15px;
    padding-bottom: 15px;
    border: 0;
    border-radius: 0;
    margin-bottom: 0;
    font-size: 12px;
    letter-spacing: 5px;
  }
  .navbar-nav  li a:hover {
    color: #1abc9c !important;
  }
  
  .row {
  margin: 10px -16px;
}

/* Add padding BETWEEN each column */
.row,
.row > .column {
  padding: 8px;
}

/* Create three equal columns that floats next to each other */
.column {
  float: left;
  width: 33.33%;
 
}

/* Clear floats after rows */ 
.row:after {
  content: "";
  display: table;
  clear: both;
}

/* Content */
.content {
  background-color: white;
  padding: 10px;
}

/* The "show" class is added to the filtered elements */
.show {
  display: block;
}
  
</style>
</head>
<body>
<form action="CartServlet"  action="MenuServlet" method="post">
<!-- Navbar -->
<nav class="navbar navbar-default">
  <div class="container">
  <a class="navbar-brand js-scroll-trigger" href="#page-top">Apple Store</a>
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="ShowCartServlet">Cart</a></li>
        <li><a href="OrderServlet">My Orders</a></li>
      </ul>
    </div>
  </div>
</nav>

<!-- Portfolio Gallery Grid -->
<div class="row">
  <div class="column nature">
    <div class="content" align="center">
      <img src="img/i7.jpg" alt="Iphone 7" style="width:90%">
      <h4>Iphone7</h4>
      <p>&#8360;39999</p>
      
      <a href="CartServlet?pid=Iphone7&price=39999" class="btn btn-default">Add to Cart</a>
    </div>
  </div>
  
  <div class="column nature">
    <div class="content" align="center">
    <img src="img/i8.jpg" alt="Iphone 8" style="width:55%">
      <h4>Iphone8</h4>
      <p>&#8360;49999</p>
      <a href="CartServlet?pid=Iphone8&price=49999" class="btn btn-default">Add to Cart</a>
    </div>
  </div>
  
  <div class="column nature">
    <div class="content" align="center">
    <img src="img/imini.jpg" alt="Ipad mini" style="width:70%">
      <h4>Ipad Mini</h4>
      <p>&#8360;28999</p>
      <a href="CartServlet?pid=IpadMini&price=28999" class="btn btn-default">Add to Cart</a>
    </div>
  </div>
  </div>
  <div class="row">
   <div class="column nature">
    <div class="content" align="center">
      <img src="img/ipro.jpg" alt="Ipad pro" style="width:70%">
      <h4>Ipad Pro </h4>
      <p>&#8360;42999</p>
      <a href="CartServlet?pid=Ipad pro&price=42999" class="btn btn-default">Add to Cart</a>
    </div>
  </div>
  <div class="column nature">
    <div class="content" align="center">
    <img src="img/ixr.jpg" alt="Iphone XR" style="width:50%">
      <h4>Iphone XR</h4>
      <p>&#8360;57999</p>
      <a href="CartServlet?pid=iphonexr&price=57999" class="btn btn-default">Add to Cart</a>
    </div>
  </div>
  
  <div class="column nature">
  <div class="content" align="center">
    <img src="img/mb air.jpg" alt="macbookair" style="width:60%">
      <h4>MacBook Air</h4>
      <p>&#8360;79999</p>
      <a href="CartServlet?pid=macair&price=79999" class="btn btn-default">Add to Cart</a>
    </div>
  </div>
  </div>
  <div class="row">
  <div class="column nature">
    <div class="content" align="center">
    <img src="img/ixs.jpg" alt="Iphone XS" style="width:70%">
      <h4>Iphone XS</h4>
      <p>&#8360;99999</p>
      <a href="CartServlet?pid=iphonexs&price=99999" class="btn btn-default">Add to Cart</a>
    </div>
  </div>
  
  <div class="column nature">
    <div class="content" align="center">
    <img src="img/ixsm.jpg" alt="Iphone XS Max" style="width:30%">
      <h4>Iphone XS Max</h4>
      <p>&#8360;129999</p>
      <a href="CartServlet?pid=iphonexsm&price=129999" class="btn btn-default">Add to Cart</a>
    </div>
  </div>
  <div class="column nature">
  <div class="content" align="center">
    <img src="img/mb pro.jpg" alt="macbookair" style="width:60%">
      <h4>MacBook Pro</h4>
      <p>&#8360;89999</p>
      <a href="CartServlet?pid=macpro&price=89999" class="btn btn-default">Add to Cart</a>
    </div>
  </div>
  </div>
 </form>
</body>
</html>