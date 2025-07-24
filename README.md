<!--
  SpringMVC Calculator README
  Filename: README.md
-->

<h1 align="center" style="color:#2971c2;">🌟 SpringMVC Multi-Expression Calculator 🌟</h1>

<p align="center">
  <img src="images/calculator_demo.png" alt="Calculator Screenshot" width="480"/>
</p>

<p align="center" style="font-size:18px;">
  A simple, modern, and flexible calculator built with <b>Spring MVC, JSP, and pure Java</b>.<br>
  Handles full arithmetic expressions like <code>10+5-10/2</code> with real-time evaluation.
</p>

<hr>

<h2>Features</h2>
<ul>
  <li> <b>Pure Java Expression Evaluator:</b> No ScriptEngine or third-party math libraries!</li>
  <li> <b>Supports multi-operator expressions,</b> parentheses, decimals, and operator precedence.</li>
  <li> Simple, clean UI (customizable via CSS).</li>
  <li> Input and result views using JSP.</li>
  <li> Graceful error handling for invalid expressions or division by zero.</li>
</ul>

<h2> Project Structure</h2>

<pre>
SpringMVC-Calculator/
 ├── src/
 │   └── main/
 │       └── java/com/example/SpringMVC/
 │           └── HomeController.java
 ├── src/
 │   └── main/
 │       └── webapp/
 │           └── views/
                    ├── index.jsp
 │                  └── result.jsp
 │       └── resources/static/
 │           ├── index.css
 │           └── result.css
 ├── README.md
 └── ...
</pre>

<h2>Getting Started</h2>

<ol>
  <li>
    <b>Clone the repository</b>
    <pre><code>git clone  https://github.com/rakeshullengula56/SpringMVC.git</code></pre>
  </li>
  <li>
    <b>Import as a Maven project</b> (using Eclipse/IntelliJ or your favorite IDE).
  </li>
  <li>
    <b>Build &amp; Run</b> the application.<br>
    (You may use <code>mvn clean install</code> and deploy to an embedded Tomcat, or use your IDE's server.)
  </li>
  <li>
    <b>Access in browser:</b><br>
    <code>http://localhost:8080/SpringMVC-Calculator/</code>
  </li>
</ol>

<h2>Usage Example</h2>

<pre>
Input:    10+5-10/2
Output:   <span style="color:#208740;font-weight:bold;">10.0</span>
</pre>

<ul>
  <li>Supports: <code>+</code>, <code>-</code>, <code>*</code>, <code>/</code>, parentheses, decimals</li>
  <li>Handles spaces in the expression gracefully</li>
  <li>Shows error messages for invalid syntax or division by zero</li>
</ul>

<h2>Customization</h2>
<ul>
  <li>Customize <code>calculator.css</code> and <code>result.css</code> in <code>resources/static/css/</code> for your own style!</li>
</ul>

<h2>License</h2>
<p>
  &copy; 2024 Rakesh Ullengula &mdash; Contributions welcome!
</p>

---

<p align="center" style="font-size:16px">
  <b>Enjoy using the SpringMVC Calculator! ⭐️</b>
</p>

