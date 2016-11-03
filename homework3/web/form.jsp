<%--
Copyright: 2016 Jenny Faig & Tyler LaVecchia
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html" />

<form action="calculate" method="post">
  <h1>Future Value Calculator</h1>
  <input type="hidden" name="action" value="add">
  <p>
      <label class="amount">Investment Amount </label>
      <input name="principal" type="number" min="0" autofocus required/>
  </p>
  <p>
      <label>Yearly Interest Rate </label>
      <input name="rate" type="number" min="0" required/>
  </p>
  <p>
      <label class="numYears">Number of Years </label>
      <input name="years" type="number" min="0" 
             required placeholder="Integer number of years"/>
  </p>
  <p class="SubmitButton">
      <input class="button" type="submit" value="Calculate"/>
  </p>
</form>

<c:import url="/includes/footer.html" />
