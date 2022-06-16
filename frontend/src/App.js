import './App.css';
import {BrowserRouter as Router, Routes, Route, Link} from 'react-router-dom'
import ListUserComponent from './components/ListUserComponent';
import FooterComponent from './components/partials/FooterComponent';
import HeaderComponent from './components/partials/HeaderComponent';
import ListProjectComponent from './components/ListProjectComponent';
import CreateProjectComponent from './components/CreateProjectComponent';

function App() {
  return (
    <Router>
      <div className="container-fluid">
        <HeaderComponent />
        <Routes>
          <Route path = "/users" exact element = {<ListUserComponent />}></Route>
          <Route path = "/projects" element = {<ListProjectComponent />}></Route>
          <Route path = "/project/new" element = {<CreateProjectComponent />}></Route>
        </Routes>
        <FooterComponent />
      </div>
    </Router>
    
  );
}

export default App;
