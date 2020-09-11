import React from 'react';
import { Grid, Header } from 'semantic-ui-react';

import 'semantic-ui-css/semantic.min.css';
import { useApi } from '../../hooks/useApi';
import { FormFace } from '../../components/Form';
import { Output } from '../../components/Output';

const Home = () => {

    const { response, loading, error, callApi } = useApi();

    const handleSubmit = (event) => {

        const formData = new FormData();
        const imagedata = event.target.file.files[0];
        formData.append('file', imagedata);
        callApi(formData);

    }

    return (
        <Grid textAlign='center' style={{ height: '100vh' }} verticalAlign='middle'>
            <Grid.Column width={4} style={{ maxWidth: 400 }}>
                <Header
                    as='h1'
                    color='teal'
                    textAlign='center'>
                    Face
                </Header>

                <FormFace handleSubmit={handleSubmit} loading={loading} />

            </Grid.Column>

            <Grid.Column width={9}>
                {
                    response.length > 0
                        ? <Output response={response} error={error} />
                        : ""
                }

            </Grid.Column>
        </Grid>
    )
}

export default Home
