import React, { useEffect, useState } from 'react'
import Container from 'react-bootstrap/Container';
import Table from 'react-bootstrap/Table';
import { show_alert } from '../../functions';
import axios from 'axios';

import Swal from 'sweetalert2';
import withReactContent from 'sweetalert2-react-content'

export const Album = () => {
  const apiUrl = 'http://54.164.31.87:8080/album/';

    const [albums, setAlbum] = useState([]);
    const [id, setId] = useState('');
    const [nameAlbum, setNameAlbum] = useState('');
    const [release_date, setNRelease_date] = useState('');
    const [numSongs, setNumSongs] = useState('');
    const [sales, setSales] = useState('');

    const [title, setTitle] = useState('');

    useEffect(() => {
        getAlbum();
    }, []);

    const getAlbum = async () => {
        const respuesta = await axios.get(apiUrl);
        setAlbum(respuesta.data)
    }

    return (
        <Container>
            <div>
                <br />
                <h2>Album</h2>
                <br />
            </div>
            <Table className='table table-hover'>
                <thead>
                    <tr className='table-danger'>
                        <th>#</th>
                        <th>Nombre del album</th>
                        <th>Fecha de lanzamiento</th>
                        <th>Numero de canciones</th>
                        <th>Ventas</th>
                    </tr>
                </thead>
                <tbody>
                    {albums.map((album, i) => (
                        <tr key={album.id} className="table-active">
                            <td>{(i+1)}</td>
                            <td>{album.nameAlbum}</td>
                            <td>{album.release_date}</td>
                            <td>{album.numSongs}</td>
                            <td>{album.sales}</td>
                        </tr>
                    ))
                    }

                </tbody>
            </Table>
        </Container>

    )
}

export default Album