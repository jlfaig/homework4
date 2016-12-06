<%--
Copyright: 2016 Jenny Faig & William Breen
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html" />

  <section>
    <h2 class="checkout">Checkout a book</h2>
    
      <form action="library" method="post">
        <input type="hidden" name="action" value="add">
        <label class="fname">First Name:</label>
        <input class="fnameBlank" type="text" name="firstName" value="${book.firstName}" required><br>
        <label class="lname">Last Name:</label>
        <input class = "lnameBlank" type="text" name="lastName" value="${book.lastName}" required><br>
        <label class="email">Email Address:</label>
        <input class = "emailBlank" type="email" name="email" value="${book.email}" required><br>
        <label class="title">Book Title:</label>
        <input class="titleBlank" type="text" name="title" value="${book.title}" required><br>
        <input class="checkoutButton" type="submit" value="Checkout">
    </form>
</section>


<c:import url="/includes/footer.html" />