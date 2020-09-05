import React, { useState } from 'react';
import { Button, Form, Grid, Header, Segment } from 'semantic-ui-react';

import 'semantic-ui-css/semantic.min.css';
import { useFetch } from './../../hooks/useFetch';

const Home = () => {

    const [value, setvalue] = useState({ file: null });
    const { response, loading, error, callApi } = useFetch('http://localhost:8080/face/recognition');

    const handleChange = ({ target }) => {
        setvalue({ [target.name]: URL.createObjectURL(target.files[0]) })
        console.log(value);
    }
    const handleSubmit = (event) => {

        const formData = new FormData();
        const imagedata = event.target.file.files[0];
        formData.append('file', imagedata);
        callApi(formData);


    }


    return (
        <Grid textAlign='center' style={{ height: '100vh' }} verticalAlign='middle'>
            <Grid.Column style={{ maxWidth: 450 }}>
                <Header
                    as='h1'
                    color='teal'
                    textAlign='center'>
                    Face
                </Header>
                <Form size='large' onSubmit={handleSubmit} encType="multipart/form-data" >
                    <Segment stacked>
                        {
                            value.file
                                ? <img
                                    src={value.file}
                                    alt="image preview"
                                    style={{ maxWidth: 450 }}
                                />
                                : ''
                        }
                        <Form.Input
                            type="file"
                            name="file"
                            fluid icon='photo'
                            iconPosition='left'
                            placeholder='Url...'
                            onChange={handleChange}
                        />
                        {
                            loading
                                ? 'Loadig...'
                                : <Button
                                    color='teal'
                                    fluid size='large'
                                >
                                    Enviar
                                </Button>
                        }
                        <div>
                            {
                                error.message
                                ? `Ocurrio un error: ${error.message}`
                                : ''
                            }
                            {response.length > 0
                                ? JSON.stringify(response)
                                : ''}
                        </div>
                    </Segment>
                </Form>
            </Grid.Column>
        </Grid>
    )
}

export default Home
