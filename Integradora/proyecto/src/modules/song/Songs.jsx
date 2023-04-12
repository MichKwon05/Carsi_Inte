import React, { useEffect, useState } from 'react'
import Container from 'react-bootstrap/Container';
import Table from 'react-bootstrap/Table';
import { show_alert } from '../../functions';
import axios from 'axios';

import Swal from 'sweetalert2';
import withReactContent from 'sweetalert2-react-content'

export const Songs = () => {
  const apiUrl = 'http://localhost:8080/songs/';

  const [songs, setSongs] = useState([]);
  const [id, setId] = useState('');
  const [nameSong, setNameSong] = useState('');
  const [release_date, setRelease_date] = useState('');
  const [awards, setAwads] = useState('');
  const [album, setAlbum] = useState('');

  const [title, setTitle] = useState('');

  useEffect(() => {
    getSongs();
  }, []);

  const getSongs = async () => {
    const respuesta = await axios.get(apiUrl);
    setSongs(respuesta.data)
  }

  return (
    <Container>
      <div>
        <br />
        <h2>Canciones</h2>
        <br />
      </div>
      <Table className='table table-hover'>
        <thead>
          <tr className='table-danger'>
            <th>#</th>
            <th>Nombre de la canción</th>
            <th>Fecha de lanzamiento</th>
            <th>Premios</th>
            <th>Album</th>
          </tr>
        </thead>
        <tbody>
          {songs.map((song, i) => (
            <tr key={song.id} className="table-active">
              <td>{(i + 1)}</td>
              <td>{song.nameSong}</td>
              <td>{song.release_date}</td>
              <td>{song.awards}</td>
              <td>{song.album}</td>
            </tr>
          ))
          }

        </tbody>
      </Table>
    </Container>
  )
}

export default Songs