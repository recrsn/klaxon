import { useMutation, useQuery } from '@tanstack/react-query';
import queryClient from 'Frontend/queryClient';
import EnvironmentRequest from 'Frontend/generated/com/recrsn/klaxon/dto/EnvironmentRequest';
import { EnvironmentEndpoint } from 'Frontend/generated/endpoints';

export function useEnvironments() {
  const { data, error, isLoading } = useQuery({
    queryKey: ['environments'],
    queryFn: () => EnvironmentEndpoint.list(),
  });
  return { data, error, isLoading };
}

export function useEnvironment(key: string) {
  const { data, error, isLoading } = useQuery({
    queryKey: ['environments', key],
    queryFn: () => EnvironmentEndpoint.getDetailByKey(key),
  });
  return { data, error, isLoading };
}

export function useCreateEnvironment() {
  return useMutation({
    mutationFn: (environment: EnvironmentRequest) => EnvironmentEndpoint.create(environment),
    onSuccess: () => {
      // Invalidate and refetch
      queryClient.invalidateQueries({ queryKey: ['environments'] });
    },
  });
}
