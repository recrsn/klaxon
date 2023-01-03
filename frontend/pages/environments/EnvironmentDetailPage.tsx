import { useEnvironment } from 'Frontend/hooks/environments';
import Loader from 'Frontend/components/Loader';
import { Link, useParams } from 'react-router-dom';
import { useEventsByEnvironment } from 'Frontend/hooks/events';

export default function EnvironmentDetailPage() {
  const { key } = useParams();
  const { data, isLoading } = useEnvironment(key!);
  const events = useEventsByEnvironment(key!);
  return (
    <section className="flex flex-col p-m gap-m">
      {isLoading && <Loader />}
      {!isLoading && data && (
        <>
          <h1>
            {data.name} ({data.key})
          </h1>
          <p>{data.description}</p>
          <h2>Services</h2>
          <ul>
            {data.services?.map((service) => (
              <li key={service?.key}>
                <Link to={`/services/${service?.key}`}>{service?.name}</Link>
              </li>
            ))}
          </ul>
          <h2>Events</h2>
          <table>
            <thead>
              <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Data</th>
                <th>Tags</th>
              </tr>
            </thead>
            <tbody>
              {events.data?.map((event) => (
                <tr key={event.id}>
                  <td>
                    <code>{event.id}</code>
                  </td>
                  <td>
                    <code>{event.key}</code>
                  </td>
                  <td>
                    <pre>{JSON.stringify(event.data)}</pre>
                  </td>
                  <td>
                    <pre>{JSON.stringify(event.tags)}</pre>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </>
      )}
    </section>
  );
}
