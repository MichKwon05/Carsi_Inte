import './App.css';

import { BrowserRouter, Route, Routes } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootswatch/dist/sketchy/bootstrap.min.css';
import Nabvar from './shared/Nabvar';

///pages
import { Members } from './modules/miembros/Members';
import { Songs} from './modules/song/Songs.jsx';
import {Album} from './modules/album/Album.jsx';
import {Marca} from './modules/marca/Marca.jsx';
import Error from './shared/Error';

function App() {
  return (
    <BrowserRouter>
      <Nabvar/>
        <Routes>
          <Route path="/" element={<Members/>} />
          <Route path="/members" element={<Members/>} />
          <Route path="/songs" element={<Songs/>} />
          <Route path="/album" element={<Album/>} />
          <Route path="/marcas" element={<Marca/>} />
          <Route path="/*" element={<Error/>} />
        </Routes>
    </BrowserRouter>
  );
}

export default App;
