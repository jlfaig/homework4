<%--
Copyright: 2016 Jenny Faig & William Breen
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html" />

  <section>
    <h2>Checkout a book</h2>
    
      <form action="LibraryServlet" method="post">
        <input type="hidden" nam="action" value="add">
        <label class="fname">First Name:</label>
        <input type="text" name="firstName" value="{user.firstName}" required><br>
        <label class="lname">Last Name:</label>
        <input class="text" name="lastName" value="{user.lastName}" required><br>
        <label class="email">Email:</label>
        <input class="email" name="email" value="{user.email}" required><br>
        <label class="title">Book Title:</label>
        <input class="title" name="title" value="{user.title}" required>
        <input type="submit" value="Checkout">
    </form>
</section>


<c:import url="/includes/footer.html" />