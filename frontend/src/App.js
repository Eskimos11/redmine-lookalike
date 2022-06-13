import './App.css';
import ListUserComponent from './components/ListUserComponent';

function App() {
  return (
    <div className="container-fluid">
      <div className='dark-blue row'>Home / Project / Administration / Help</div>
      <div className='light-blue row'>Project name</div>
      <ListUserComponent />
    </div>
  );
}

export default App;
